package ph.jomaribenito.churchtracker.persistence.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ph.jomaribenito.churchtracker.persistence.DatabaseObject;


public abstract class Database<V extends DatabaseObject> {
    protected Context context;
    protected SQLiteDatabase sqLiteDatabase;

    public abstract String getTableName();

    public abstract ContentValues convertToContentValues(V obj);

    public abstract V convertToDatabaseObject(Cursor cursor);

    public Database(Context context, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    public void deleteAllItems() {
        sqLiteDatabase.delete(getTableName(), null, null);
    }

    public long insertItem(V obj) {
        return insertItem(convertToContentValues(obj), true);
    }

    public long insertItem(ContentValues contentValues, boolean startTransaction) {
        long id;
        if (startTransaction)
            sqLiteDatabase.beginTransaction();
        id = sqLiteDatabase.insert(getTableName(), null, contentValues);
        if (startTransaction) {
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
        }
        return id;
    }

    public void insertItems(List<V> objects) {
        sqLiteDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : convertToContentValues(objects)) {
                int id = getID(contentValues.getAsInteger("id"));
                if (id == -1)
                    insertItem(contentValues, false);
                else {
                    updateItem(contentValues, "id =? ", new String[]{"" + id},
                            false);
                }
            }
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    public void insertItemsWithoutUpdateCheck(List<V> objects) {
        sqLiteDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : convertToContentValues(objects)) {
                insertItem(contentValues, false);
            }
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    public void updateItems(List<V> objects, String whereClause,
                            String[] whereArgs) {

        sqLiteDatabase.beginTransaction();
        try {
            for (ContentValues contentValues : convertToContentValues(objects)) {
                String clause;
                if (whereClause != null)
                    clause = whereClause + " AND id =? ";
                else
                    clause = "id =? ";
                String[] args = new String[1];
                if (whereArgs != null) {
                    args = new String[whereArgs.length + 1];
                    for (int i = 0; i < whereArgs.length; i++) {
                        args[i] = whereArgs[i];
                    }
                }
                args[args.length - 1] = "" + contentValues.getAsInteger("id");
                if (getID(contentValues.getAsInteger("id")) == -1)
                    insertItem(contentValues, false);
                else
                    updateItem(contentValues, clause, args, false);
            }
            sqLiteDatabase.setTransactionSuccessful();
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    public void updateItem(ContentValues contentValues, String whereClause,
                           String[] whereArgs, boolean startTransaction) {
        if (startTransaction)
            sqLiteDatabase.beginTransaction();
        sqLiteDatabase.update(getTableName(), contentValues, whereClause, whereArgs);
        if (startTransaction) {
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
        }
    }

    public ContentValues[] convertToContentValues(List<V> databaseObjects) {
        ContentValues[] contentValues = new ContentValues[databaseObjects.size()];
        for (int i = 0; i < contentValues.length; i++)
            contentValues[i] = convertToContentValues(databaseObjects.get(i));
        return contentValues;
    }

    public int getID(int id) {
        Cursor c = sqLiteDatabase.query(getTableName(), new String[]{"_id"}, "id =? ",
                new String[]{"" + id}, null, null, null, null);
        if (c.moveToFirst()) { //if the row exist then return the id
            int num = c.getInt(c.getColumnIndex("_id"));
            c.close();
            return num;
        }
        return -1;
    }

    public List<V> getAllItems() {
        return getAllItemsBySelection(null, null);
    }

    public List<V> getAllItems(String orderBy) {
        return getAllItemsBySelection(null, null);
    }

    public List<V> getAllItemsBySelection(String arg, String selection) {
        return getAllItemsBySelection(arg, selection, null);
    }

    public List<V> getAllItemsBySelection(String arg, String selection, String orderBy) {
        String[] args = null;

        if (arg != null) {
            args = new String[1];
            args[0] = arg;
        }
        return getAllItemsByMultipleSelection(args, selection == null ? null : selection + " =? ",
                orderBy);
    }

    public List<V> getAllItemsByMultipleSelection(String[] args, String selection, String orderBy) {
        Cursor cursor = sqLiteDatabase.query(getTableName(), null,
                selection, args,null, null, orderBy);

        List<V> items = new ArrayList<>();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    V obj = convertToDatabaseObject(cursor);
                    items.add(obj);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return items;
    }

    public int getItemCount(String arg, String selection) {
        boolean hasArgs = true;
        String[] args = null;

        if(arg == null)
            hasArgs = false;
        else {
            args = new String[1];
            args[0] = arg;
        }

        Cursor cursor = sqLiteDatabase.query(getTableName(), null,
                selection == null ? null : selection + " =? ", hasArgs ? args : null,
                null, null, null);

        if (cursor != null) {
            int count = cursor.getCount();
            cursor.close();
            return count;
        }

        return 0;
    }
}
