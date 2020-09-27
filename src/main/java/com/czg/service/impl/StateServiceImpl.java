package com.czg.service.impl;

import com.czg.dao.StateDao;
import com.czg.domain.TaskState;
import com.czg.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements IStateService {

    @Autowired
    private StateDao stateDao;

    @Override
    public List<TaskState> selectTaskState() {
        return stateDao.selectTaskState();
    }
}
