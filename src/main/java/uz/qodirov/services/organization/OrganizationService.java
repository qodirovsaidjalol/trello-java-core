package uz.qodirov.services.organization;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.organization.OrganizationCreateDto;
import uz.qodirov.dtos.organization.OrganizationDto;
import uz.qodirov.dtos.organization.OrganizationUpdateDto;
import uz.qodirov.enums.HttpStatus;
import uz.qodirov.exception.ApiRuntimeException;
import uz.qodirov.exception.CustomerSQLException;
import uz.qodirov.repository.organization.OrganizationRepository;
import uz.qodirov.response.Data;
import uz.qodirov.response.ResponseEntity;
import uz.qodirov.security.SecurityHolder;
import uz.qodirov.services.AbstractService;
import uz.qodirov.services.GenericCrudService;
import uz.qodirov.services.GenericService;

import java.util.List;

public class OrganizationService extends AbstractService<OrganizationRepository>
        implements GenericCrudService<
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto,
        Long>, GenericService<OrganizationDto, GenericCriteria> {

    public OrganizationService(OrganizationRepository repository) {
        super(repository);
    }


    @Override
    public ResponseEntity<Data<Long>> create(OrganizationCreateDto dto) {
        try {
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<OrganizationDto>> get(Long id) {
        try {
            OrganizationDto organizationDto = repository.get(id);
            return new ResponseEntity<>(new Data<>(organizationDto));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(OrganizationUpdateDto dto) {
        try {
            if (!hasPermission("ORGANIZATION_UPDATE"))
                throw new ApiRuntimeException("PERMISSION_DENIED", HttpStatus.HTTP_401);

            if (!SecurityHolder.authUserSession.isSuperUser()
                    && !SecurityHolder.authUserSession.getOrganization().getId().equals(dto.getId()))
                throw new ApiRuntimeException("PERMISSION_DENIED", HttpStatus.HTTP_401);

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
    public ResponseEntity<Data<List<OrganizationDto>>> list(GenericCriteria criteria) {
        try {
            List<OrganizationDto> organizationsDto = repository.list(new GenericCriteria());
            return new ResponseEntity<>(new Data<>(organizationsDto, organizationsDto.size()));
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }
}
