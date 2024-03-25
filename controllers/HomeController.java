package controllers;

import models.*;
import views.HomeView;
import java.util.List;
import static java.lang.Integer.parseInt;
import java.lang.String;


public class HomeController {

    private HomeView homeView;
    private String finalResult;

    public HomeController(HomeView homeView, List<Monomial> users){
        this.homeView = homeView;

        this.homeView.addAdditionListener(e->{
            try{

                homeView.setResultField(null);
                finalResult="";

                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                poly1=citire(homeView.getFirstField());
                poly2=citire(homeView.getSecondField());

                Polynomial result=Polynomial.addition(poly1,poly2);

                for(Monomial mono: result.getPolinom())
                    finalResult=finalResult.concat(mono.toString());

                if(finalResult=="")
                    finalResult=finalResult.concat("0");

                if(finalResult.startsWith("+"))
                    homeView.setResultField(finalResult.substring(1));
                else homeView.setResultField(finalResult);


            }
            catch(Exception ex){
                System.out.println("eroare Adunare");
            }
        });

        this.homeView.addSubstractionListener(e->{
            try{

                homeView.setResultField(null);
                finalResult="";

                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                poly1=citire(homeView.getFirstField());
                poly2=citire(homeView.getSecondField());

                Polynomial result=Polynomial.substraction(poly1,poly2);

                for(Monomial mono: result.getPolinom())
                    finalResult=finalResult.concat(mono.toString());

                if(finalResult=="")
                    finalResult=finalResult.concat("0");

                if(finalResult.startsWith("+"))
                    homeView.setResultField(finalResult.substring(1));
                else homeView.setResultField(finalResult);
            }
            catch(Exception ex){
                System.out.println("eroare Scadere");
            }
        });

        this.homeView.addMultiplicationListener(e->{
            try{

                homeView.setResultField(null);
                finalResult="";

                Polynomial poly1=new Polynomial();
                Polynomial poly2=new Polynomial();
                poly1=citire(homeView.getFirstField());
                poly2=citire(homeView.getSecondField());

                Polynomial result=Polynomial.multiplication(poly1,poly2);

                for(Monomial mono: result.getPolinom())
                    finalResult=finalResult.concat(mono.toString());

                if(finalResult.startsWith("+"))
                    homeView.setResultField(finalResult.substring(1));
                else homeView.setResultField(finalResult);

            }
            catch(Exception ex){
                System.out.println("eroare Inmultire");
            }
        });

        this.homeView.addDivisionListener(e->{
            try{

            }
            catch(Exception ex){
                System.out.println("eroare Impartire");
            }
        });

        this.homeView.addDerivativeListener(e->{
            try{

                homeView.setResultField(null);

                finalResult="";
                Polynomial poly=new Polynomial();

                poly=citire(homeView.getFirstField());
                Polynomial result=Polynomial.derivative(poly);

                for(Monomial mono: result.getPolinom())
                     finalResult=finalResult.concat(mono.toString());

                if(finalResult=="")
                    finalResult=finalResult.concat("0");

                if(finalResult.startsWith("+"))
                  homeView.setResultField(finalResult.substring(1));
                else homeView.setResultField(finalResult);

            }
            catch(Exception ex){
                System.out.println("eroare Derivare");
            }
        });

        this.homeView.addIntegrationListener(e->{
            try{

                homeView.setResultField(null);
                finalResult="";

                Polynomial poly=new Polynomial();

                poly=citire(homeView.getFirstField());
                Polynomial result=Polynomial.integration(poly);

                for(Monomial mono: result.getPolinom())
                    finalResult=finalResult.concat(mono.toString2());

                if(finalResult=="")
                    finalResult=finalResult.concat("0");

                if(finalResult.startsWith("+"))
                    homeView.setResultField(finalResult.substring(1));
                else homeView.setResultField(finalResult);

            }
            catch(Exception ex){
                System.out.println("eroare Integrare");
            }
        });
}

    public Polynomial citire(String poly){

       Polynomial newPolinom=new Polynomial();
       int aux=0;

        for (String monomial : poly.split("(?=\\+)|(?=-)"))
        {
            aux++;
            Monomial mono = new Monomial(0,0);
            int indexX=monomial.indexOf("x");


                if(indexX>1)
                {
                    mono.setCoef(parseInt(monomial.substring(0,indexX)));
                    int indexP=monomial.indexOf("^");
                    if(indexP>=0)
                        mono.setGrad((parseInt(monomial.substring(indexP+1))));
                    else mono.setGrad(1);
                }


                else if(indexX<0)
                {
                    mono.setCoef(parseInt(monomial));
                    mono.setGrad(0);
                }

                else if(indexX==0 ) {
                    mono.setCoef(1);
                    int indexP = monomial.indexOf("^");
                    if (indexP >= 0)
                        mono.setGrad((parseInt(monomial.substring(indexP + 1))));
                    else mono.setGrad(1);
                }
                else if(indexX==1 ) {

                    if(aux!=1)
                    {

                    if(monomial.startsWith("-"))
                         mono.setCoef(-1);
                    else mono.setCoef(1);

                    int indexP = monomial.indexOf("^");
                    if (indexP >= 0)
                        mono.setGrad((parseInt(monomial.substring(indexP + 1))));
                    else mono.setGrad(1);
                    }

                    else {
                        mono.setCoef(parseInt(monomial.substring(0,indexX)));
                        int indexP=monomial.indexOf("^");
                        if(indexP>=0)
                            mono.setGrad((parseInt(monomial.substring(indexP+1))));
                        else mono.setGrad(1);
                    }
                }

               newPolinom.add(mono);
        }
       return newPolinom;
    }
}
