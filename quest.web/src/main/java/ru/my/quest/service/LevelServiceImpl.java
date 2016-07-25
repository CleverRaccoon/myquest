package ru.my.quest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.my.quest.repository.LevelRepository;

/**
 * Created by maksim on 6/11/2016.
 */
@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public void createLevel() {

    }

    @Override
    public void deleteLevel() {

    }

    @Override
    public void editLevel() {

    }
}
