package uz.qodirov.services.task;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.task.TaskCreateDto;
import uz.qodirov.dtos.task.TaskDto;
import uz.qodirov.dtos.task.TaskUpdateDto;
import uz.qodirov.exception.ApiRuntimeException;
import uz.qodirov.exception.CustomerSQLException;
import uz.qodirov.repository.task.TaskRepository;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;
import uz.qodirov.services.AbstractService;
import uz.qodirov.services.GenericCrudService;
import uz.qodirov.services.GenericService;

import java.util.List;


public class TaskService extends AbstractService<TaskRepository> implements GenericCrudService<
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto,
        Long>,
        GenericService<TaskDto, GenericCriteria> {

    public TaskService(TaskRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(TaskCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<TaskDto>> get(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.get(id)));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(TaskUpdateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.update(dto)));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        try {
            repository.delete(id);
            return new ResponseEntity<>(new Data<>(null));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<List<TaskDto>>> list(GenericCriteria criteria) {
        try {
            return new ResponseEntity<>(new Data<>(repository.list(criteria)));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }
}
