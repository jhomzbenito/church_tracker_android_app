package ph.jomaribenito.churchtracker.persistence.models;

public class PayloadFieldDatabase{

    /*@Inject
    public PayloadFieldDatabase(Context context) {
        super(context , DatabaseHelper.getInstance(context).openDatabase());
    }

    @Override
    public String getTableName() {
        return ContentDescription.PayloadFieldTable.TABLE_NAME;
    }

    @Override
    public ContentValues convertToContentValues(PayloadField obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentDescription.PayloadFieldTable.COLUMN.PAYLOAD_ID, obj.getPayload_id());
        contentValues.put(ContentDescription.PayloadFieldTable.COLUMN.DESCRIPTION, obj.getDescription());
        contentValues.put(ContentDescription.PayloadFieldTable.COLUMN.FORMAT, obj.getFormat());
        contentValues.put(ContentDescription.PayloadFieldTable.COLUMN.MAX_LENGTH, obj.getMax_length());
        contentValues.put(ContentDescription.PayloadFieldTable.COLUMN.TYPE, obj.getType());
        contentValues.put(ContentDescription.PayloadFieldTable.COLUMN.HINT, obj.getHint());
        return contentValues;
    }

    @Override
    public PayloadField convertToDatabaseObject(Cursor cursor) {
        PayloadField obj = new PayloadField();
        obj.setPayload_id(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.PayloadFieldTable.COLUMN.PAYLOAD_ID
        )));
        obj.setDescription(cursor.getString(cursor.getColumnIndex(
                ContentDescription.PayloadFieldTable.COLUMN.DESCRIPTION
        )));
        obj.setFormat(cursor.getString(cursor.getColumnIndex(
                ContentDescription.PayloadFieldTable.COLUMN.FORMAT
        )));
        obj.setMax_length(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.PayloadFieldTable.COLUMN.MAX_LENGTH
        )));
        obj.setHint(cursor.getString(cursor.getColumnIndex(
                ContentDescription.PayloadFieldTable.COLUMN.HINT
        )));
        return obj;
    }*/
}
