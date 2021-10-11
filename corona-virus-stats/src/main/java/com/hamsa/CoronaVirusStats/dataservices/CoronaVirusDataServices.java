package com.hamsa.CoronaVirusStats.dataservices;

import com.hamsa.CoronaVirusStats.model.CoronaVirusLiveDetails;
import lombok.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class CoronaVirusDataServices {
    private static final String LATEST_CORONA_VIRUS_DEATH = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

    public List<CoronaVirusLiveDetails> allCoronaVirus = new ArrayList<>();

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void getConfirmedCoronaVirusWorldWideCases() throws IOException, InterruptedException {
        List<CoronaVirusLiveDetails> localCoronaVirusList = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(LATEST_CORONA_VIRUS_DEATH))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        StringReader stringReader = new StringReader(response.body());
        Iterable<CSVRecord> csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
        for(CSVRecord csvRecord : csvRecords) {
            CoronaVirusLiveDetails coronaVirusLiveDetails = new CoronaVirusLiveDetails();
            if(!StringUtils.isEmptyOrWhitespace(csvRecord.get("Province/State"))) {
                coronaVirusLiveDetails.setProvince(csvRecord.get("Province/State"));
                coronaVirusLiveDetails.setCountry(csvRecord.get("Country/Region"));
                coronaVirusLiveDetails.setLatitude(Double.parseDouble(csvRecord.get("Lat")));
                coronaVirusLiveDetails.setLongitude(Double.parseDouble(csvRecord.get("Long")));
                coronaVirusLiveDetails.setDeathCount(Integer.parseInt(csvRecord.get(csvRecord.size() - 1)));

                localCoronaVirusList.add(coronaVirusLiveDetails);
            }
        }
        this.allCoronaVirus = localCoronaVirusList;
    }
}
