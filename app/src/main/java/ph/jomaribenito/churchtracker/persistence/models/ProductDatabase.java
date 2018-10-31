package ph.jomaribenito.churchtracker.persistence.models;

public class ProductDatabase {

    /*@Inject
    public ProductDatabase(Context context) {
        super(context, DatabaseHelper.getInstance(context).openDatabase());
    }

    @Override
    public String getTableName() {
        return ContentDescription.ProductTable.TABLE_NAME;
    }

    @Override
    public ContentValues convertToContentValues(Products obj) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContentDescription.ProductTable.COLUMN.ID, obj.getProduct_id());
        contentValues.put(ContentDescription.ProductTable.COLUMN.PRODUCT_CATEGORY_ID, obj.getProduct_category_id());
        contentValues.put(ContentDescription.ProductTable.COLUMN.SKU, obj.getSku());
        contentValues.put(ContentDescription.ProductTable.COLUMN.NAME, obj.getName());
        contentValues.put(ContentDescription.ProductTable.COLUMN.CREDITS, obj.getCredits());
        contentValues.put(ContentDescription.ProductTable.COLUMN.ENABLED, obj.isEnabled() ? 1 : 0);
        contentValues.put(ContentDescription.ProductTable.COLUMN.CREATED_AT, obj.getCreated_at());
        contentValues.put(ContentDescription.ProductTable.COLUMN.UPDATED_AT, obj.getUpdated_at());
        contentValues.put(ContentDescription.ProductTable.COLUMN.ARBITRARY_CREDITS, obj.getArbitrary_credits());
        contentValues.put(ContentDescription.ProductTable.COLUMN.DESCRIPTION, obj.getDescription());
        contentValues.put(ContentDescription.ProductTable.COLUMN.SERVICE_FEE_FORMULA, obj.getService_fee_formula());
        contentValues.put(ContentDescription.ProductTable.COLUMN.REBATES_FORMULA, obj.getRebates_formula());
        contentValues.put(ContentDescription.ProductTable.COLUMN.CONVENIENCE_ENABLED, obj.isConvenience_enabled() ? 1 : 0);
        return contentValues;
    }

    @Override
    public Products convertToDatabaseObject(Cursor cursor) {
        Products obj = new Products();
        obj.setProduct_id(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.ID
        )));
        obj.setProduct_category_id(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.PRODUCT_CATEGORY_ID
        )));
        obj.setSku(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.SKU
        )));
        obj.setName(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.NAME
        )));
        obj.setCredits(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.CREDITS
        )));
        obj.setEnabled(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.ENABLED
        )) == 1);
        obj.setCreated_at(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.CREATED_AT
        )));
        obj.setUpdated_at(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.UPDATED_AT
        )));
        obj.setArbitrary_credits(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.ARBITRARY_CREDITS
        )));
        obj.setDescription(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.DESCRIPTION
        )));
        obj.setService_fee_formula(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.SERVICE_FEE_FORMULA
        )));
        obj.setRebates_formula(cursor.getString(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.REBATES_FORMULA
        )));
        obj.setConvenience_enabled(cursor.getInt(cursor.getColumnIndex(
                ContentDescription.ProductTable.COLUMN.CONVENIENCE_ENABLED
        )) == 1);
        return obj;
    }*/
}
