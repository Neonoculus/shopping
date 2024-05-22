package dao.impl;

import dao.Page;

import java.util.List;

public class PageImpl<T> implements Page<T> {
    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Override
    public int getTotalRows() {
        return 0;
    }

    @Override
    public List<T> getPagedData() {
        return null;
    }

    @Override
    public int getTotalPages() {
        return 0;
    }

    @Override
    public int getStartRow() {
        return 0;
    }

    @Override
    public int getEndRow() {
        return 0;
    }

    @Override
    public int getPreviousPage() {
        return 0;
    }

    @Override
    public int getNextPage() {
        return 0;
    }
}
