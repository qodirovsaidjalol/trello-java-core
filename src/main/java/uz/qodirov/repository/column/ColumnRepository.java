package uz.qodirov.repository.column;

import com.google.gson.reflect.TypeToken;
import uz.qodirov.criterias.project.ProjectCriteria;
import uz.qodirov.dtos.column.ColumnCreateDto;
import uz.qodirov.dtos.column.ColumnDto;
import uz.qodirov.dtos.column.ColumnUpdateDto;
import uz.qodirov.exception.ApiRuntimeException;
import uz.qodirov.exception.CustomerSQLException;
import uz.qodirov.repository.AbstractRepository;
import uz.qodirov.repository.GenericCrudRepository;
import uz.qodirov.repository.GenericRepository;
import uz.qodirov.security.SecurityHolder;

import java.sql.Types;
import java.util.List;

public class ColumnRepository extends AbstractRepository
        implements GenericCrudRepository<ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto,
        Long>, GenericRepository<ColumnDto, ProjectCriteria> {


    @Override
    public Long create(ColumnCreateDto dto) {
        try {
            prepareArguments(gson.toJson(dto), SecurityHolder.authUserSession.getId());
            return callProcedure(property.get("column.create"), Types.BIGINT, Long.class);
        } catch (CustomerSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    @Override
    public ColumnDto get(Long id) {
        return null;
    }

    @Override
    public Boolean update(ColumnUpdateDto dto) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ColumnDto> list(ProjectCriteria criteria) {
        prepareArguments(criteria.getProjectId());
        String jsonData = (String) callProcedure(property.get("column.list"), Types.VARCHAR);
        return gson.fromJson(jsonData, new TypeToken<List<ColumnDto>>() {
        }.getType());
    }
}
