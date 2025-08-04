package com.data.structures.algorithms.java.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


public class Main {

    public static void main(String[] args) {
        showsInProduction(2011, 2011).forEach(System.out::println);
    }

    public static List<String> showsInProduction(int startYear, int endYear) {
        List<String> res = new ArrayList<>();
        try {
            List<Series> seriesList = getSeriesData();
            for (Series series: seriesList) {
                String runtime = series.runtimeOfSeries.replace("I", "").replace("(", "").replace(")", "").trim();
                int sYear = 0;
                int eYear = 0;
                System.out.println(runtime);
                if (runtime.contains("-")) {
                    String[] years = runtime.split("-");
                    sYear = Integer.parseInt(years[0]);
                    eYear = years.length > 1 ? Integer.parseInt(years[1]) : -1;
                } else {
                    sYear = Integer.parseInt(runtime);
                }
                if (sYear >= startYear) {
                    if (startYear == endYear && startYear == sYear && eYear == 0) {
                        res.add(series.name);
                    } else if (endYear == -1 && eYear == -1) {
                        res.add(series.name);
                    } else if (eYear > 0 && eYear <= endYear) {
                        res.add(series.name);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(res);
        return res;
    }

    public static List<Series> getSeriesData() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        List<ApiResponse> seriesList = new ArrayList<>();
        Gson gson = new Gson();
        for (int i = 1; i <= 20; i++) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonmock.hackerrank.com/api/tvseries?page=" + i))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            seriesList.add(gson.fromJson(response.body(), ApiResponse.class));
        }
        List<Series> seriesList1 = new ArrayList<>();
        for (ApiResponse response: seriesList) {
            seriesList1.addAll(response.data);
        }
        return seriesList1;
    }

}

class ApiResponse {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Series> data;
}
class Series {
    @SerializedName("name")
    String name;
    @SerializedName("runtime_of_series")
    String runtimeOfSeries;
    @SerializedName("certificate")
    String certificate;
    @SerializedName("runtime_of_episodes")
    String runtimeOfEpisodes;
    @SerializedName("genre")
    String genre;
    @SerializedName("imdb_rating")
    double imdbRating;
    @SerializedName("overview")
    String overview;
    @SerializedName("no_of_votes")
    int noOfVotes;
    @SerializedName("id")
    int id;
}
