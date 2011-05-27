package bigfishing.utils;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import sun.management.FileSystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * User: zhaoyao
 * Date: 11-5-27
 * Time: PM6:49
 */
public class I18nResource implements InitializingBean, DisposableBean {

    private Map<Locale, Resource> languageResources;
    private Map<Locale, Long> lastModifiedTimestamps = new HashMap<Locale, Long>();

    private Map<Locale, Props> languageEntries = new HashMap<Locale, Props>();

    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private Time time = new SystemTime();

    public void setTime(Time time) {
        this.time = time;
    }

    public String getLanguageEntry(String key, Locale locale) {
        Props props = languageEntries.get(locale);
        if (props == null) {
            throw new IllegalArgumentException("language resource file for " + locale + " is not properly configured.");
        }

        return props.getString(key);
    }

    public void setLanguageResources(Map<Locale, Resource> languageResources) {

        this.languageResources = languageResources;
    }

    public Map<Locale, Resource> getLanguageResources() {
        return languageResources;
    }


    @Override
    public void destroy() throws Exception {
        scheduledExecutorService.shutdownNow();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (languageResources == null) {
            throw new IllegalArgumentException("no language resource provided.");
        }

        for (Locale locale : languageResources.keySet()) {
            lastModifiedTimestamps.put(locale, time.getMilliseconds());
        }

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {

                        for (Map.Entry<Locale, Resource> entry : languageResources.entrySet()) {
                            try {
                                if (entry.getValue().lastModified() >= lastModifiedTimestamps.get(entry.getKey())) {
                                    Props props = new Props(entry.getValue().getFile());
                                    languageEntries.put(entry.getKey(), props);
                                }
                            } catch (IOException e) {
                                continue;
                            }
                        }


                    }
                }, 0, 10, TimeUnit.MINUTES);
    }
}
