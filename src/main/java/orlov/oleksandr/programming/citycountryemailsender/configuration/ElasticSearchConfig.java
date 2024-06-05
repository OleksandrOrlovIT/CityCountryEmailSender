package orlov.oleksandr.programming.citycountryemailsender.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@AllArgsConstructor
@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    private final Dotenv dotenv;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(
                        dotenv.get("ELASTICSEARCH_HOST") +
                                ":" +
                                dotenv.get("ELASTICSEARCH_PORT")
                )
                .build();
    }

}
