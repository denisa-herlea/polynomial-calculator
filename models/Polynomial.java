package models;

import java.util.ArrayList;
import java.util.List;

public class Polynomial  {

    private List<Monomial> poly;

    public Polynomial() {
        poly = new ArrayList<Monomial>();
    }

    public List<Monomial> getPolinom() {
        return poly;
    }

    public void add(Monomial m) {
        poly.add(m);
    }


    public static Polynomial sortareMultiplication(Polynomial p){

        Polynomial poly=new Polynomial();
        Monomial newMonomial;
        int gradMax=0,i;

        for(Monomial mono:p.getPolinom())
            if(mono.getGrad()>=gradMax)
                gradMax= mono.getGrad();

        for(i=gradMax;i>=0;i--)
        {
            float s=0;
            for(Monomial mono:p.getPolinom())
                if(mono.getGrad()==i)
                {
                    s=(int)s+mono.getCoef();
                }
        newMonomial= new Monomial (s ,i);
        poly.add(newMonomial);
        }
        return poly;
    }


    public static Polynomial sortare(Polynomial p){

        Polynomial poly=new Polynomial();
        int gradMax=0,i;

        for(Monomial mono:p.getPolinom())
            if(mono.getGrad()>=gradMax)
                gradMax= mono.getGrad();

        for(i=gradMax;i>=0;i--)
            for(Monomial mono:p.getPolinom())
                  if(mono.getGrad()==i)
                  {
                      poly.add(mono);
                  }
          return poly;
    }

    public static Polynomial addition(Polynomial poly1, Polynomial poly2){

        Polynomial resultPolynomial =new Polynomial();
        Polynomial resultPolynomial2 =new Polynomial();
        Monomial resultMonomial;

        for(Monomial mono1: poly1.getPolinom())
        { for(Monomial mono2: poly2.getPolinom())
                  if(mono1.getGrad()==mono2.getGrad())
                  {
                      resultMonomial=new Monomial((int)mono1.getCoef()+mono2.getCoef(), mono1.getGrad());
                      mono1.setVisited(true);
                      mono2.setVisited(true);
                      resultPolynomial.add(resultMonomial);
                  }}
        for(Monomial mono1:poly1.getPolinom())
            if(!mono1.isVisited())
                resultPolynomial.add(mono1);

        for(Monomial mono2:poly2.getPolinom())
            if(!mono2.isVisited())
                resultPolynomial.add(mono2);
        resultPolynomial2=sortare(resultPolynomial);
            return resultPolynomial2;
    }

    public static Polynomial substraction(Polynomial poly1, Polynomial poly2){

        Polynomial resultPolynomial =new Polynomial();
        Polynomial resultPolynomial2 =new Polynomial();
        Monomial resultMonomial;

        for(Monomial mono2:poly2.getPolinom())
            mono2.setCoef(-mono2.getCoef());

        for(Monomial mono1: poly1.getPolinom())
        { for(Monomial mono2: poly2.getPolinom())
            if(mono1.getGrad()==mono2.getGrad())
            {
                resultMonomial=new Monomial((int)mono1.getCoef()+mono2.getCoef(), mono1.getGrad());
                mono1.setVisited(true);
                mono2.setVisited(true);
                resultPolynomial.add(resultMonomial);
            }}
        for(Monomial mono1:poly1.getPolinom())
            if(!mono1.isVisited())
                resultPolynomial.add(mono1);

        for(Monomial mono2:poly2.getPolinom())
            if(!mono2.isVisited())
                resultPolynomial.add(mono2);

        resultPolynomial2=sortare(resultPolynomial);
        return resultPolynomial2;
    }

    public static Polynomial multiplication(Polynomial poly1, Polynomial poly2){

        Polynomial resultPolynomial =new Polynomial();
        Polynomial resultPolynomial2 =new Polynomial();
        Monomial resultMonomial;

        for(Monomial mono1: poly1.getPolinom())
        { for(Monomial mono2: poly2.getPolinom())
            {
                resultMonomial=new Monomial((int)mono1.getCoef()*mono2.getCoef(), mono1.getGrad()+mono2.getGrad());
                resultPolynomial.add(resultMonomial);
            }}

        resultPolynomial2=sortareMultiplication(resultPolynomial);
        return resultPolynomial2;
    }

    public static void division(Polynomial p1, Polynomial p2){

    }

    public static Polynomial derivative(Polynomial p){

       Polynomial resultPolynomial2=new Polynomial();
        for(Monomial mono: p.getPolinom())
          { mono.setCoef((int)mono.getCoef()*mono.getGrad());
            mono.setGrad(mono.getGrad()-1);}
        resultPolynomial2=sortare(p);
        return resultPolynomial2;
    }

    public static Polynomial integration(Polynomial p){

        Polynomial resultPolynomial2=new Polynomial();
        for(Monomial mono: p.getPolinom())
            {
            mono.setCoef(mono.getCoef()/(mono.getGrad()+1)) ;
            mono.setGrad(mono.getGrad()+1);
            }
        resultPolynomial2=sortare(p);
        return resultPolynomial2;
    }

}
