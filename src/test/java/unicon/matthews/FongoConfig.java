package unicon.matthews;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

/**
 * @author ggilbert
 * @author xchopin <xavier.chopin@univ-lorraine.fr>
 */
@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages={"unicon.matthews.oneroster.service.repository"})
public class FongoConfig extends AbstractMongoConfiguration {

  @Override
  protected String getDatabaseName() {
      return "fongo-test";
  }

  @Bean
  public Mongo mongo() {
      Fongo queued = new Fongo("fongo");
      return queued.getMongo();
  }

  @Override
  protected String getMappingBasePackage() {
      return "apereo.openlrw";
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
      return new MongoTemplate(mongo(), getDatabaseName());
  }
}
