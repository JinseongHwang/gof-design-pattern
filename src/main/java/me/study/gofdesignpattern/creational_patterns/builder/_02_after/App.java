package me.study.gofdesignpattern.creational_patterns.builder._02_after;

public class App {

    public static void main(String[] args) {
        final TourDirector director = new TourDirector(new DefaultTourBuilder());
        final TourPlan tourPlan1 = director.cancunTrip();
        final TourPlan tourPlan2 = director.longBeachTrip();

        System.out.println(tourPlan1);
        System.out.println(tourPlan2);
    }
}
