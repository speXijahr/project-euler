package cz.vaic.learning.helpers;

import java.util.List;
import java.util.NoSuchElementException;

public class StreamHelpers {
    public static long findHighestNumberInList(List<Long> list) {
        return list.stream()
                .max(Long::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

}
