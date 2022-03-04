package uz.qodirov.services.user;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.auth.UserCreateDto;
import uz.qodirov.dtos.auth.UserUpdateDto;
import uz.qodirov.dtos.user.BlockDto;
import uz.qodirov.dtos.user.UserDto;
import uz.qodirov.repository.user.UserRepository;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;
import uz.qodirov.services.AbstractService;
import uz.qodirov.services.GenericCrudService;
import uz.qodirov.services.GenericService;

import java.util.List;

public class UserService extends AbstractService<UserRepository>
        implements GenericCrudService<UserDto, UserCreateDto, UserUpdateDto, Long>,
        GenericService<UserDto, GenericCriteria> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public ResponseEntity<Data<Long>> create(UserCreateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<UserDto>> get(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(UserUpdateDto dto) {
        return null;
    }

    @Override
    public ResponseEntity<Data<Void>> delete(Long id) {
        repository.delete(id);
        return new ResponseEntity<>(new Data<>(null));
    }

    @Override
    public ResponseEntity<Data<List<UserDto>>> list(GenericCriteria criteria) {
        return null;
    }

    public ResponseEntity<Data<Boolean>> block(BlockDto dto) {
        repository.block(dto);
        return null;
    }
}
