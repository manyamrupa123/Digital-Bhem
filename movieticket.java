import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private String title;
    private int availableSeats;

    public Movie(String title, int availableSeats) {
        this.title = title;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeats(int numSeats) {
        if (numSeats > 0 && numSeats <= availableSeats) {
            availableSeats -= numSeats;
            System.out.println("Seats booked successfully!");
        } else {
            System.out.println("Invalid number of seats or not enough available seats.");
        }
    }
}

class Booking {
    private Movie movie;
    private int numSeats;

    public Booking(Movie movie, int numSeats) {
        this.movie = movie;
        this.numSeats = numSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getNumSeats() {
        return numSeats;
    }
}

class MovieTicketBookingSystem {
    private List<Movie> movies;
    private List<Booking> bookings;

    public MovieTicketBookingSystem() {
        movies = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void displayMovies() {
        System.out.println("Available Movies:");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - Available Seats: " + movie.getAvailableSeats());
        }
    }

    public void bookTickets(Movie movie, int numSeats) {
        Booking booking = new Booking(movie, numSeats);
        movie.bookSeats(numSeats);
        bookings.add(booking);
    }

    public void displayBookings() {
        System.out.println("Booked Tickets:");
        for (Booking booking : bookings) {
            System.out.println("Movie: " + booking.getMovie().getTitle() + ", Seats: " + booking.getNumSeats());
        }
    }

    public static void main(String[] args) {
        MovieTicketBookingSystem bookingSystem = new MovieTicketBookingSystem();

        Movie movie1 = new Movie("Tiger", 50);
        Movie movie2 = new Movie("Mangalavaram", 60);
	Movie movie3 = new Movie("Skandha", 45);
	Movie movie4 = new Movie("Bhagavanth Kesari", 30);
	Movie movie5 = new Movie("Vasu", 90);

        bookingSystem.addMovie(movie1);
        bookingSystem.addMovie(movie2);
	bookingSystem.addMovie(movie3);
	bookingSystem.addMovie(movie4);
	bookingSystem.addMovie(movie5);

        bookingSystem.displayMovies();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the movie title you want to book tickets for:");
        String selectedMovie = scanner.nextLine();

        Movie chosenMovie = null;
        for (Movie movie : bookingSystem.movies) {
            if (movie.getTitle().equalsIgnoreCase(selectedMovie)) {
                chosenMovie = movie;
                break;
            }
        }

        if (chosenMovie != null) {
            System.out.println("Enter the number of seats you want to book:");
            int numSeats = scanner.nextInt();

            bookingSystem.bookTickets(chosenMovie, numSeats);
            bookingSystem.displayBookings();
        } else {
            System.out.println("Movie not found.");
        }

        scanner.close();
    }
}

