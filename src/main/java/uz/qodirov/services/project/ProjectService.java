package uz.qodirov.services.project;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.project.ProjectCreateDto;
import uz.qodirov.dtos.project.ProjectDto;
import uz.qodirov.dtos.project.ProjectUpdateDto;
import uz.qodirov.exception.ApiRuntimeException;
import uz.qodirov.exception.CustomerSQLException;
import uz.qodirov.repository.project.ProjectRepository;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;
import uz.qodirov.services.AbstractService;
import uz.qodirov.services.GenericCrudService;
import uz.qodirov.services.GenericService;

import java.util.List;


public class ProjectService extends AbstractService<
        ProjectRepository> implements GenericCrudService<
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        Long>, GenericService<ProjectDto, GenericCriteria> {

    public ProjectService(ProjectRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(ProjectCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<ProjectDto>> get(Long id) {
        try {
            ProjectDto projectDto = repository.get(id);
            return new ResponseEntity<>(new Data<>(projectDto));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());

        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(ProjectUpdateDto dto) {
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
    public ResponseEntity<Data<List<ProjectDto>>> list(GenericCriteria criteria) {
        try {
            List<ProjectDto> projectDtoList = repository.list(new GenericCriteria());
            return new ResponseEntity<>(new Data<>(projectDtoList, projectDtoList.size()));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

//    public ResponseEntity<Data<List<UserDto>>> getMembers(Long id) {
//        try {
//            List<Session> authUsers = repository.getMembers(id);
//            return new ResponseEntity<>(new Data<>(authUsers));
//        } catch (CustomerSQLException e) {
//            return new ResponseEntity<>(new Data<>(e.getFriendlyMessage()), e.getStatus());
//        }
//    }
}
