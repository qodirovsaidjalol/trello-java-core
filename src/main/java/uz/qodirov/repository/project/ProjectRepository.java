package uz.qodirov.repository.project;

import com.google.gson.reflect.TypeToken;
import uz.qodirov.container.UNIContainer;
import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.project.ProjectCreateDto;
import uz.qodirov.dtos.project.ProjectDto;
import uz.qodirov.dtos.project.ProjectUpdateDto;
import uz.qodirov.property.DatabaseProperties;
import uz.qodirov.repository.AbstractRepository;
import uz.qodirov.repository.GenericCrudRepository;
import uz.qodirov.repository.GenericRepository;
import uz.qodirov.security.SecurityHolder;
import uz.qodirov.utils.BaseUtils;

import java.sql.Types;
import java.util.List;

public class ProjectRepository extends AbstractRepository implements GenericCrudRepository<
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        Long>, GenericRepository<ProjectDto, GenericCriteria> {
    @Override
    public Long create(ProjectCreateDto dto) {
        prepareArguments(BaseUtils.gson.toJson(dto), SecurityHolder.authUserSession.getId());
        return (Long) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("create.project"), Types.BIGINT);
    }


    @Override
    public Boolean update(ProjectUpdateDto dto) {
        prepareArguments(SecurityHolder.authUserSession.getId(), BaseUtils.gson.toJson(dto));
        return (boolean) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("unblock.project"), Types.VARCHAR);
    }

    @Override
    public void delete(Long id) {
        prepareArguments(SecurityHolder.authUserSession.getId(), id);
        callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("delete.project"), -1);
    }

    @Override
    public ProjectDto get(Long id) {
        prepareArguments(id, SecurityHolder.authUserSession.getId());
        String dataJson = (String) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("project.get"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(dataJson, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> list(GenericCriteria criteria) {
        prepareArguments(SecurityHolder.authUserSession.getId());
        String data = (String) callProcedure(UNIContainer.getBean(DatabaseProperties.class).get("list.project"), Types.VARCHAR);
        return BaseUtils.gson.fromJson(data, new TypeToken<List<ProjectDto>>() {
        }.getType());
    }

}
