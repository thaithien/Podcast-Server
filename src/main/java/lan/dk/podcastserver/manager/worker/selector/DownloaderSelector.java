package lan.dk.podcastserver.manager.worker.selector;

import lan.dk.podcastserver.manager.worker.downloader.Downloader;
import lan.dk.podcastserver.manager.worker.downloader.NoOpDownloader;
import lombok.Setter;
import org.jadira.usertype.spi.utils.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Set;

/**
 * Created by kevin on 17/03/15.
 */
@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
public class DownloaderSelector {

    public static final NoOpDownloader NO_OP_DOWNLOADER = new NoOpDownloader();

    @Setter(onMethod = @__(@Autowired))
    private Set<Downloader> downloaders;

    public Downloader of(String url) {
        if (StringUtils.isEmpty(url)) {
            return NO_OP_DOWNLOADER;
        }

        return downloaders
                .stream()
                .min(Comparator.comparing(downloader -> downloader.compatibility(url)))
                .orElse(NO_OP_DOWNLOADER);
    }
}