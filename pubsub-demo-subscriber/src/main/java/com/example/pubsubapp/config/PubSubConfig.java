package com.example.pubsubapp.config;

import com.google.cloud.spring.pubsub.core.subscriber.PubSubSubscriberTemplate;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PubSubConfig {

    @Bean
    public MessageChannel inputMessageChannel() {
        return new DirectChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter inboundChannelAdapter(
            PubSubSubscriberTemplate subscriberTemplate,
            MessageChannel inputMessageChannel) {

        PubSubInboundChannelAdapter adapter =
                new PubSubInboundChannelAdapter(subscriberTemplate, "user-notification-sub");
        adapter.setOutputChannel(inputMessageChannel);
        return adapter;
    }
}
