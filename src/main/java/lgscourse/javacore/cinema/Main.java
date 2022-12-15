package lgscourse.javacore.cinema;


import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static java.lang.System.*;
import static java.time.LocalTime.*;

public class  Main {
    static lgscourse.javacore.cinema.Cinema cinema = new lgscourse.javacore.cinema.Cinema();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        Time open, close;
        while (true) {
            showMenu();
            switch (scanner.nextLine().toLowerCase()) {
                case "*":
                    while (true) {
                        try {
                            open = new Time(parse(scanner.nextLine()));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again( hh:mm hh:mm ):");
                        }
                    }
                    while (true) {
                        try {
                            close = new Time(parse(scanner.nextLine()));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again( hh:mm hh:mm ):");
                        }
                    }
                    cinema = new lgscourse.javacore.cinema.Cinema(open, close);
                    break;
                case "1":
                    cinema.showSchedules();
                    break;
                case "2":
                    cinema.showMovies();
                    break;
                case "3":
                    out.println("Enter a title of movie");
                    out.println("Enter Movie genre");
                    String title= scanner.nextLine();
                    String genre= scanner.nextLine();

                    Time duration;
                    while (true) {
                        try {
                            out.println("Enter a duration of movie hh:mm");
                            duration = new Time(parse(scanner.nextLine()));
                            cinema.addMovie(new Movie(title, duration));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again (hh:mm):");
                        }
                    }
                    break;
                case "4":
                    out.println("Enter a title of movie");
                    out.println("Enter movie genre");
                    title = scanner.nextLine();
                    genre = scanner.nextLine();
                    out.println("Enter a duration of movie hh:mm");
                    while (true) {
                        try {
                            duration = new Time(parse(scanner.nextLine()));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again (hh:mm):");
                        }
                    }
                    out.println("Enter a start time of the seance hh:mm");
                    Time start;
                    while (true) {
                        try {
                            start = new Time(parse(scanner.nextLine()));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again(hh:mm):");
                        }
                    }
                    String day;
                    while (true) {
                        try {
                            out.println("Enter a day of the seance (SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY)");
                            day = scanner.nextLine();
                            cinema.addSeance(new Seance(new Movie(title, duration), start), day);
                            break;
                        } catch (IllegalArgumentException e) {
                            out.println("Incorrect day of week");
                        }
                    }
                    break;
                case "5":
                    out.println("Enter a title of movie");
                    out.println("Enter movie genre");
                    title = scanner.nextLine();
                    genre = scanner.nextLine();

                    out.println("Enter a duration of movie hh:mm");
                    while (true) {
                        try {
                            duration = new Time(parse(scanner.nextLine()));
                            cinema.removeMovie(new Movie(title, duration));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again (hh:mm):");
                        }
                    }
                    break;
                case "6":
                    out.println("Enter a title of movie");
                    out.println("Enter movie genre");
                    title = scanner.nextLine();
                    genre = scanner.nextLine();
                    out.println("Enter a duration of movie hh:mm");
                    while (true) {
                        try {
                            duration = new Time(parse(scanner.nextLine()));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again (hh:mm):");
                        }
                    }
                    out.println("Enter a start time of the seance hh:mm");
                    while (true) {
                        try {
                            start = new Time(parse(scanner.nextLine()));
                            break;
                        } catch (DateTimeParseException dtp) {
                            out.println("Incorrect time data, enter again (hh:mm):");
                        }
                    }
                    while (true) {
                        try {
                            out.println("Enter a day of the seance (SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY)");
                            day = scanner.nextLine();
                            cinema.removeSeance(new Seance(new Movie(title, duration), start), day);
                            break;
                        } catch (IllegalArgumentException e) {
                            out.println("Incorrect day of week");
                        }
                    }
                    break;
                case "exit":
                    scanner.close();
                    exit(0);
                    break;
                default:
                    out.println("Incorrect input");
                    break;
            }
        }

    }

    public static void showMenu() {
        if (cinema.getOpen() != null && cinema.getClose() != null)
            out.println("The cinema is opened at " + cinema.getOpen() + ", closed at " + cinema.getClose());
        out.println("1 - Show schedule of the cinema");
        out.println("2 - Show all movies");
        out.println("3 - Add new movie");
        out.println("4 - Add new seance");
        out.println("5 - Remove movie");
        out.println("6 - Remove seance");
        out.println("exit - To exit. ");
    }
}