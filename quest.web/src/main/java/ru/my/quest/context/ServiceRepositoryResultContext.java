package ru.my.quest.context;

import lombok.Data;

/**
 * Created by maksim on 6/9/2016.
 */

@Data
public class ServiceRepositoryResultContext<T> extends AbstractResultContext {

    private T id;

}
