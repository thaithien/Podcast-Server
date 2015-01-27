package lan.dk.podcastserver.repository.specification;

import com.mysema.query.types.expr.BooleanExpression;
import lan.dk.podcastserver.entity.QItem;
import lan.dk.podcastserver.entity.Tag;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by kevin on 08/06/2014.
 */
public class ItemSpecifications {

    public static BooleanExpression isDownloaded(Boolean downloaded) {
        QItem item = QItem.item;

        if (downloaded)
            return item.status.eq("Finish");

        return item.status.isNull().or(item.status.eq("Not Downloaded"));
    }

    public static BooleanExpression isNewerThan(ZonedDateTime dateTime){
        return QItem.item.pubdate.gt(dateTime);
    }

    public static BooleanExpression isOlderThan(ZonedDateTime dateTime){
        return QItem.item.pubdate.lt(dateTime);
    }

    public static BooleanExpression hasToBeDeleted(Boolean deleted){
        QItem item = QItem.item;

        if (deleted)
            return item.podcast.hasToBeDeleted.isTrue();

        return item.podcast.hasToBeDeleted.isFalse();

    }

    public static BooleanExpression isInId(final List<Integer> ids){
        return QItem.item.id.in(ids);
    }

    public static BooleanExpression isInTags(List<Tag> tags) {
        return isInTags(tags.toArray(new Tag[tags.size()]));
    }

    public static BooleanExpression isInTags(final Tag... tags) {
        if (tags.length == 0)
            return null;

        QItem item = QItem.item;

        BooleanExpression tagsPredicate = null;

        for (Tag tag : tags) {
            tagsPredicate =
                    (tagsPredicate == null)
                            ? item.podcast.tags.contains(tag)
                            : tagsPredicate.and(item.podcast.tags.contains(tag));
        }

        return tagsPredicate;
    }

    public static BooleanExpression hasStatus(final String... statuses) {
        if (statuses.length == 0)
            return null;

        QItem item = QItem.item;

        BooleanExpression statusPredicate = null;

        for (String status : statuses) {
            statusPredicate =
                    (statusPredicate == null)
                        ? item.status.eq(status)
                        : statusPredicate.or(item.status.eq(status));
        }

        return statusPredicate;
    }

    public static BooleanExpression isInPodcast(Integer podcastId) {
        return QItem.item.podcast.id.eq(podcastId);
    }
}
