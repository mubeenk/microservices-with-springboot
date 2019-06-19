package demo;

import org.apache.lucene.queryparser.xml.builders.FuzzyLikeThisQueryBuilder;
import org.apache.lucene.sandbox.queries.FuzzyLikeThisQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

@SpringBootApplication
public class LivelessonsDataElasticsearchApplication {

	@Bean
	public InitializingBean seedDatabase(CarRepository repository) {
		return () -> {
			repository.deleteAll();
			repository.save(new Car("Honda", "Civic", 1997));
			repository.save(new Car("Honda", "Accord", 2003));
			repository.save(new Car("Ford", "Escort", 1985));
		};
	}

	@Bean
	public CommandLineRunner example(CarRepository repository,
			ElasticsearchTemplate template) {
		return (args) -> {
			System.err.println("From the repository...");
			repository.findByMakeIgnoringCase("fOrD").forEach(System.err::println);

			System.err.println("\nFrom the template...");
			SearchQuery query = (SearchQuery) new NativeSearchQueryBuilder();
//			SearchQuery query = new NativeSearchQueryBuilder()
//					.withQuery((QueryBuilder) new FuzzyLikeThisQueryBuilder("make", "Ronda")).build();
			template.queryForList(query, Car.class).forEach(System.err::println);
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LivelessonsDataElasticsearchApplication.class, args);
	}

}
