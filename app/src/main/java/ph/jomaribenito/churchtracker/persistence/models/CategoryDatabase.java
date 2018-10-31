package ph.jomaribenito.churchtracker.persistence.models;

public class CategoryDatabase{

    /*@Inject
    public CategoryDatabase(Context context) {
        super(context, DatabaseHelper.getInstance(context).openDatabase());
    }

    @Override
    public String getTableName() {
        return ContentDescription.CategoryTable.TABLE_NAME;
    }

    @Override
    public ContentValues convertToContentValues(CategoryResponse obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentDescription.CategoryTable.COLUMN.ID, obj.getCategory_id());
        contentValues.put(ContentDescription.CategoryTable.COLUMN.NAME, obj.getName());
        contentValues.put(ContentDescription.CategoryTable.COLUMN.DESCRIPTION, obj.getDescription());
        return contentValues;
    }

    @Override
    public CategoryResponse convertToDatabaseObject(Cursor cursor) {
        CategoryResponse obj = new CategoryResponse();
        obj.setCategory_id(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.CategoryTable.COLUMN.ID
        )));
        obj.setName(cursor.getString(cursor.getColumnIndex(
                ContentDescription.CategoryTable.COLUMN.NAME
        )));
        obj.setDescription(cursor.getString(cursor.getColumnIndex(
                ContentDescription.CategoryTable.COLUMN.DESCRIPTION
        )));
        return obj;
    }*/
}
