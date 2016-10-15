package de.klingbeil.swag.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@Configuration
@ComponentScan("de.klingbeil.swag")
@EnableMongoRepositories("de.klingbeil.swag.persistence.repository")
public class FakeMongoConfig extends AbstractMongoConfiguration {


    @Override
    protected String getDatabaseName() {
        return "teamgeist-dev";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Fongo("fongo").getMongo();
    }

}
