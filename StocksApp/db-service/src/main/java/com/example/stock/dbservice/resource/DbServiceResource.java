package com.example.stock.dbservice.resource;


import com.example.stock.dbservice.model.Quote;
import com.example.stock.dbservice.model.Quotes;
import com.example.stock.dbservice.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

    private QuotesRepository quotesRepository;

    public DbServiceResource(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String userName) {

        return getQuotesByUserName(userName);
    }

    private List<String> getQuotesByUserName(@PathVariable("username") String userName) {
        return quotesRepository.findByUserName(userName)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> add(@RequestBody final Quotes quotes) {
        for (String quote : quotes.getQuotes()) {
            Quote quote1 = new Quote(quotes.getUserName(), quote);
            quotesRepository.save(quote1);
        }

        return getQuotesByUserName(quotes.getUserName());
    }
}