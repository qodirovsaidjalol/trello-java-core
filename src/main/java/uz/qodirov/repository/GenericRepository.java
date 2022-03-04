package uz.qodirov.repository;

import uz.qodirov.criterias.GenericCriteria;
import uz.qodirov.dtos.GenericDto;

import java.util.List;

public interface GenericRepository<D extends GenericDto, C extends GenericCriteria> {
    List<D> list(C criteria);
}
