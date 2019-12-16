package fashionPOS.Util;

import java.util.List;

/**
 * Steven Rumanto
 * 1772026
 */

public interface DaoServiceCRUD<T> {
    int addData(T object);
    List<T> getAllData();
    T getData(T object);
    int updateData(T object);
    int deleteData(T object);
}
