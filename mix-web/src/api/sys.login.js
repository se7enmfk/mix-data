import request from '@/plugin/axios'

export function AccountLogin(data) {
    return request({url: '/login', method: 'post', data})
};

export async function loadData(data) {
    return request({url: '/pro/dataList', method: 'post', data})
};
export function loadProDataType(data) {
    return request({url: '/pro/dataTypeList', method: 'post', data})
};
export function loadProArea(data) {
    return request({url: '/pro/areaList', method: 'post', data})
};
