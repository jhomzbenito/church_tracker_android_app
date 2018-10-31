package ph.jomaribenito.churchtracker.persistence.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class ContentDescription {
    private static final String AUTHORITY = "com.rcbc.episo";

    public static final class CategoryTable implements BaseColumns {
        public static final String TABLE_NAME = "category_table";

        public static final Uri URI = getUri(TABLE_NAME);

        public static class COLUMN {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String DESCRIPTION = "description";
        }
    }

    public static final class ProductTable implements BaseColumns {
        public static final String TABLE_NAME = "product_table";

        public static final Uri URI = getUri(TABLE_NAME);

        public static class COLUMN {
            public static final String ID = "id";
            public static final String PRODUCT_CATEGORY_ID = "product_category_id";
            public static final String SKU = "sku";
            public static final String NAME = "name";
            public static final String CREDITS = "credits";
            public static final String ENABLED = "enabled";
            public static final String CREATED_AT = "created_at";
            public static final String UPDATED_AT = "updated_at";
            public static final String ARBITRARY_CREDITS = "arbitrary_credits";
            public static final String DESCRIPTION = "description";
            public static final String PAYLOAD = "payload";
            public static final String SERVICE_FEE_FORMULA = "service_fee_formula";
            public static final String REBATES_FORMULA = "rebates_formula";
            public static final String CONVENIENCE_ENABLED = "convenience_enabled";
        }
    }

    public static final class PayloadTable implements BaseColumns {
        public static final String TABLE_NAME = "payload_table";

        public static final Uri URI = getUri(TABLE_NAME);

        public static class COLUMN {
            public static final String PRODUCT_ID = "product_id";
            public static final String FIELD_1 = "field1";
            public static final String FIELD_2 = "field2";
            public static final String FIELD_3 = "field3";
            public static final String FIELD_4 = "field4";
            public static final String FIELD_5 = "field5";
        }
    }

    public static final class PayloadFieldTable implements BaseColumns {
        public static final String TABLE_NAME = "payload_field_table";

        public static final Uri URI = getUri(TABLE_NAME);

        public static class COLUMN {
            public static final String PAYLOAD_ID = "payload_id";
            public static final String DESCRIPTION = "description";
            public static final String FORMAT = "format";
            public static final String TYPE = "type";
            public static final String MAX_LENGTH = "max_length";
            public static final String HINT = "hint";
        }
    }



    public static Uri getUri(String tableName) {
        StringBuilder authority = new StringBuilder(AUTHORITY);
        return Uri.parse("content://" + authority).buildUpon().appendPath(tableName).build();
    }
}

