package logs.dao;

import java.util.List;

public interface IBaseDao<E> {

    void add(E map);

    void delete(E map);

    List<E> select(E map);

    List<E> likeSelect(E entity);

    Long likeSelectCount(E entity);

}
