package com.example.springbootdemo.util;

public class PageHelper {
    private int pageSize;

    private int recordCount = 0;

    private int totalPages = 0;


    public void setRecordCount(int recordCountValue) {
        if(recordCountValue > 0) {
            this.recordCount = recordCountValue;
            // 计算总数据页数
            if(pageSize > 0) {
                totalPages = recordCountValue%pageSize == 0? recordCountValue/pageSize : (recordCountValue/pageSize) + 1;
            }
        }

    }

    public Integer getOffset(Integer currentPage) {
        if (recordCount <= 0) {
            return null;
        } else {
            if(currentPage == null || currentPage <= 0) {
                return 0;
            }else {
                if (currentPage >= totalPages) {
                    return (totalPages - 1) * pageSize;
                } else {
                    return (currentPage - 1) * pageSize;
                }
            }
        }
    }

    public Integer getLimit(Integer currentPage) {
        if (recordCount <= 0) {
            return null;
        }
        else {
            return pageSize;
        }
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
