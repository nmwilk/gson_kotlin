package com.sageone.kotlinjson;

import com.google.gson.Gson;

import junit.framework.Assert;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class StringModelDeserialisationTests {
    @Test
    public void goodData() {
        final Gson gson = new Gson();

        final StringModel model = gson.fromJson("{a : \"1\", b : \"2\", c: \"3\", d : \"4\"}", StringModel.class);
        Assert.assertEquals(new StringModel("1", "2", "3", "4"), model);
    }

    @Test
    public void emptyDataWithNonNullNoDefault() {
        final Gson gson = new Gson();

        final StringModel model = gson.fromJson("{b : \"2\", c: \"3\", d : \"4\"}", StringModel.class);
        Assert.assertEquals(new StringModel("1", "2", "3", "4"), model);
    }

    @Test
    public void emptyDataWithNonNullDefault() {
        final Gson gson = new Gson();

        final StringModel model = gson.fromJson("{a : \"1\", b : null, c: \"3\", d : \"4\"}", StringModel.class);
        Assert.assertEquals(new StringModel("1", "2", "3", "4"), model);
    }

    @Test
    public void emptyDataWithNullableDefault() {
        final Gson gson = new Gson();

        final StringModel model = gson.fromJson("{a : \"1\", b : \"2\", c: null, d : \"4\"}", StringModel.class);
        Assert.assertEquals(new StringModel("1", "2", null, "4"), model);
    }

    @Test
    public void emptyDataWithNullDefault() {
        final Gson gson = new Gson();

        final StringModel model = gson.fromJson("{a : \"1\", b : \"2\", c: \"3\", d : null}", StringModel.class);
        Assert.assertEquals(new StringModel("1", "2", "3", "4"), model);
        Assert.assertEquals(new StringModel("1", "2", "3", "4"), StringModelKt.createDefault());
    }
}