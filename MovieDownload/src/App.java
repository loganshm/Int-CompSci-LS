
class App {
    public static void main(String[] args) throws Exception{
        // 1. Create a new MoviePosterWriter
        MoviePosterWriter mpw = new MoviePosterWriter();
        // 2. Create a new Movie, pass it in a string of a movie title
        Movie avengers = new Movie("oppenheimer");
        // 3. use the movie poster writer to set a movie and then write it

        for (int loopCounter = 1; loopCounter < 6; loopCounter++) {

            mpw.setMovieString(avengers.getMovieNameForURL());
            mpw.write(avengers.getMovieFilename() + loopCounter + ".jpg");
        }

        // Choose your own movies here! make a loop to repeat steps 2 and 3.
        // String movies = {"avengers"};

        // this code doesn't work if you have a space in the movie name. see below
        // Movie airbud = new Movie("air bud");
        // mpw.setMovieString("air bud");
        // mpw.write("air bud");

    }
}
