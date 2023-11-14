class Movie {

    // fields 
    String movieName;
    String movieNameForUrl;
    String movieScreenshotFilename;
    
    Movie(String name) {
        movieName = name;
        movieNameForUrl = getMovieNameForURL();
        movieScreenshotFilename = getMovieFilename();
    }

    /* If there are spaces in the movie, the URL parsing fails.
     * Use String methods to replace any spaces in the movieName to 
     * "%20" or plus signs "+" to make it URL-safe, and return that string.
     * see https://www.w3schools.com/tags/ref_urlencode.ASP
     */
    String getMovieNameForURL() {
        // FILL IN CODE HERE
        String x = null;
        for(int i = 0; i < movieName.length(); i++){
            if(movieName.charAt(i) == ' '){
                x = movieName.replace(movieName.charAt(i), '+');
            }
        }
        if(x == null){
            movieNameForUrl = movieName;
            return movieNameForUrl;
        } else {
            movieNameForUrl = x;
            return movieNameForUrl;
        }
    } 

    /* If the movie doesn't have an extension, you cannot view it in VSCode correctly. 
    This method should add a ".jpg" or ".png" extension to the movie name to make it clear this is a picture.
    Also, remove spaces since spaces in filenames are ANNOYING. maybe replace with underscores?
    */
    String getMovieFilename() {
        // FILL IN CODE HERE
        String y = null;
        for(int j = 0; j < movieName.length(); j++){
            if(movieName.charAt(j) == ' '){
                y = movieName.replace(movieName.charAt(j), '_');
            }  
        }
        if(y == null){
            movieNameForUrl = movieName;
            return movieNameForUrl;
        } else {
            movieNameForUrl = y;
            return movieNameForUrl;
        }
    } 
}
