package com.dkfedko;

import org.junit.jupiter.api.Test;

public abstract class BaseTest {

    @Test
    public abstract void shouldCheckIfEmptyAddAndRemoveValue ();

    @Test
    public abstract void shouldAddAndPeek();

    @Test
    public abstract void shouldCheckIfContainsAndClean();

    @Test
    public abstract void shouldThrowExceptions();

}
