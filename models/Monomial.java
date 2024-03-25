package models;

public  class Monomial {

    private float coef;
    private int grad;
    private boolean visited;


    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Monomial(float coef, int grad) {
        this.coef = coef;
        this.grad = grad;
    }

    public String toString2() {

        if(coef==0)
            return "";
        if(grad==0 && coef>0)
            return "+" + coef ;
        if(grad==0 && coef<0)
            return  coef + "";
        if(coef==1 && grad==1)
            return "+"+"x";
        if(coef==1 && grad>1)
            return "+"+"x^"+grad;
        if(coef==-1 && grad==1 )
            return "-"+"x";
        if(coef==-1 && grad>1)
            return "-"+"x^"+grad;
        if(coef>0 && grad==1)
            return "+"+coef+"x";
        if(grad>0 && coef>0)
            return "+" + coef + "x^" + grad;
        else
            return coef + "x^" + grad;
    }


    public String toString() {

        if(coef==0)
            return "";
        if(grad==0 && coef>0)
            return "+" + (int)coef ;
        if(grad==0 && coef<0)
            return  (int)coef + "";
        if(coef==1 && grad==1)
            return "+"+"x";
        if(coef==1 && grad>1)
            return "+"+"x^"+grad;
        if(coef==-1 && grad==1 )
            return "-"+"x";
        if(coef==-1 && grad>1)
            return "-"+"x^"+grad;
        if(coef>0 && grad==1)
            return "+"+(int)coef+"x";
        if(grad>0 && coef>0)
            return "+" + (int)coef + "x^" + grad;
        else
            return (int)coef + "x^" + grad;
    }


}
