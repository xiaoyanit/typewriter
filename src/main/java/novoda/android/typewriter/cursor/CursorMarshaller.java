package novoda.android.typewriter.cursor;

import android.database.Cursor;
import novoda.android.typewriter.Marshaller;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class CursorMarshaller<T> implements Marshaller<T, Cursor> {

    @Override
    public T marshall(Cursor cur, Class<T> what) {
        if (cur.getPosition() == -1) {
            throw new RuntimeException("Cursor is at position -1");
        }

        Field[] fields = what.getFields();

   //     what.findSetterMethod("_id") => setId();
     //   what.getMapper("_id") => getClass() real name


        T obj = null;
        try {
            obj = what.newInstance();
            List<String> columnNames = Arrays.asList(cur.getColumnNames());
            for (Field field : fields) {
                if (columnNames.contains(field.getName())) {
                    field.set(obj, cur.getString(cur.getColumnIndex(field.getName())));
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}