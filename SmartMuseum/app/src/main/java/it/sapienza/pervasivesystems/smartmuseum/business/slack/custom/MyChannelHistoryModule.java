package it.sapienza.pervasivesystems.smartmuseum.business.slack.custom;

import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;

import org.threeten.bp.LocalDate;

import java.util.List;

/**
 * Created by andrearanieri on 19/06/16.
 */
public interface MyChannelHistoryModule {
    List<SlackMessagePosted> fetchHistoryOfChannel(String channelName);

    List<SlackMessagePosted> fetchHistoryOfChannel(String channelName, LocalDate day);

    List<SlackMessagePosted> fetchHistoryOfChannel(String channelName, int numberOfMessages);

    List<SlackMessagePosted> fetchHistoryOfChannel(String channelName, LocalDate day, int numberOfMessages);

    List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId);

    List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId, LocalDate day);

    List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId, int numberOfMessages);

    List<SlackMessagePosted> fetchUpdatingHistoryOfChannel(String channelId, LocalDate day, int numberOfMessages);
}
