package com.example.beanquest.room;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.beanquest.Models.PopularDish;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DishDao_Impl implements DishDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PopularDish> __insertionAdapterOfPopularDish;

  private final SharedSQLiteStatement __preparedStmtOfDeleteDish;

  public DishDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPopularDish = new EntityInsertionAdapter<PopularDish>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `popular_dishes` (`id`,`foodName`,`foodImage`,`foodPrice`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PopularDish entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getFoodName());
        statement.bindString(3, entity.getFoodImage());
        statement.bindString(4, entity.getFoodPrice());
      }
    };
    this.__preparedStmtOfDeleteDish = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM popular_dishes WHERE foodName='something'";
        return _query;
      }
    };
  }

  @Override
  public void addDish(final PopularDish dish) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPopularDish.insert(dish);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteDish() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteDish.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteDish.release(_stmt);
    }
  }

  @Override
  public List<PopularDish> getDishes() {
    final String _sql = "SELECT * FROM popular_dishes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfFoodName = CursorUtil.getColumnIndexOrThrow(_cursor, "foodName");
      final int _cursorIndexOfFoodImage = CursorUtil.getColumnIndexOrThrow(_cursor, "foodImage");
      final int _cursorIndexOfFoodPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "foodPrice");
      final List<PopularDish> _result = new ArrayList<PopularDish>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final PopularDish _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpFoodName;
        _tmpFoodName = _cursor.getString(_cursorIndexOfFoodName);
        final String _tmpFoodImage;
        _tmpFoodImage = _cursor.getString(_cursorIndexOfFoodImage);
        final String _tmpFoodPrice;
        _tmpFoodPrice = _cursor.getString(_cursorIndexOfFoodPrice);
        _item = new PopularDish(_tmpId,_tmpFoodName,_tmpFoodImage,_tmpFoodPrice);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
