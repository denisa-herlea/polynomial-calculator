import controllers.HomeController;
import models.*;
import views.HomeView;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Monomial> monomials = new ArrayList<>();

        HomeView homeView = new HomeView();
        HomeController homeController = new HomeController(homeView, monomials);
    }
}
