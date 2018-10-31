package ph.jomaribenito.churchtracker.persistence.models;

public class PayloadDatabase {

    /*@Inject
    public PayloadDatabase(Context context) {
        super(context, DatabaseHelper.getInstance(context).openDatabase());
    }

    @Override
    public String getTableName() {
        return ContentDescription.PayloadTable.TABLE_NAME;
    }

    @Override
    public ContentValues convertToContentValues(Payload obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentDescription.PayloadTable.COLUMN.PRODUCT_ID, obj.getProduct_id());
        return contentValues;
    }

    @Override
    public Payload convertToDatabaseObject(Cursor cursor) {
        Payload obj = new Payload();
        obj.setPrimary_id(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.PayloadTable._ID
        )));
        obj.setProduct_id(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.PayloadTable.COLUMN.PRODUCT_ID
        )));
        return obj;
    }*/
}
