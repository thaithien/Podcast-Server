package lan.dk.podcastserver.controller.task;

import lan.dk.podcastserver.service.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by kevin on 18/05/2016 for Podcast Server
 */
@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class DatabaseController {

    final DatabaseService databaseService;

    @RequestMapping(value = "backup", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void backup() throws IOException {
        databaseService.backupWithDefault();
    }
}
