<template>
    <d2-container :filename="filename">
        <template slot="header">
            <el-form :inline="true" :model="formData" label-width="80px">
                <el-form-item label="跨区">
                    <el-select v-model="formData.area_id" @change="onloadData" placeholder="请选择">
                        <el-option
                                v-for="item in formData.proAreas"
                                :key="item.area_id"
                                :label="item.name"
                                :value="item.area_id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="物品">
                    <el-select v-model="formData.ids" multiple filterable @change="onloadData" placeholder="请选择">
                        <!--<el-option
                                v-for="item in formData.options"
                                :key="item.id"
                                :label="item.name"
                                :value="item.id">
                        </el-option>-->
                        <el-option-group
                                v-for="group in formData.options"
                                :key="group.value"
                                :label="group.label">
                            <el-option
                                    v-for="item in group.children"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value">
                            </el-option>
                        </el-option-group>
                    </el-select>
                    <!--<el-cascader
                            v-model="formData.idd"
                            placeholder="请选择"
                            :options="formData.options"
                            :show-all-levels="false"
                            @change="onloadData"
                            filterable>
                    </el-cascader>-->
                </el-form-item>
                <el-form-item label="日期">
                    <el-date-picker
                            v-model="formData.data_dt"
                            type="daterange"
                            align="right"
                            unlink-panels
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期"
                            @change="onloadData"
                            :picker-options="pickerOptions2">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="最高值">
                    <el-input v-model="formData.max" placeholder="最高值" @change="cal()"></el-input>
                </el-form-item>
                <el-form-item label="最小值">
                    <el-input v-model="formData.min" placeholder="最小值" @change="cal()"></el-input>
                </el-form-item>
                <el-form-item label="利润">
                    <el-input v-model="formData.profit" placeholder="最小值"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onloadData">查询</el-button>
                </el-form-item>

            </el-form>
        </template>
        <div class="inner">
            <ve-line :data="formData.chartData" v-bind="pubSetting"></ve-line>
        </div>
        <template slot="footer">
        </template>
    </d2-container>
</template>

<script>
    import list from '@/pages/demo/_mixin/list.js'
    import {loadData, loadProArea, loadProDataType} from '@api/sys.login'
    import util from '@/libs/util.js'

    export default {
        //公共属性
        mixins: [
            list
        ],
        //私用属性
        data() {
            loadProDataType({}).then((data) => {
                this.formData.option_data = data;
                let options = [];
                let pList = util.listUnique(data, 'p_id');
                for (const pdata of pList) {
                    let children = [];
                    for (const datum of data) {
                        if (pdata.p_id === datum.p_id) {
                            children.push({value: datum.id, label: datum.name});
                        }
                    }
                    options.push({value: pdata.p_id, label: pdata.p_name, children: children});
                }
                this.formData.options = options;
            });

            loadProArea({}).then((data) => {
                this.formData.proAreas = data;
            });
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            // picker.$emit('pick', [start, end]);
            return {
                filename: __filename,
                formData: {
                    ids: [],
                    area_id: 35,
                    max: 0,
                    min: 0,
                    profit: 0,
                    data_dt: [start, end],
                    options: [],
                    proAreas: [],
                    chartData: {
                        columns: [],
                        rows: []
                    }
                },
                pickerOptions2: {
                    shortcuts: [{
                        text: '最近一周',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近一个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近三个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },
                setting: {xAxisType: 'time'}
            }
        },
        methods: {
            onloadData() {
                let formData = this.formData;
                // console.log(this.formData.idd);
                let list = formData.option_data.filter((item) => {
                    return formData.ids.indexOf(item.id) > -1;
                });

                let data_dt_start = formData.data_dt[0].format("yyyy-MM-dd");
                let data_dt_end = formData.data_dt[1].format("yyyy-MM-dd");

                if (formData.ids && formData.area_id) {
                    formData.chartData.columns = ['日期'];
                    formData.chartData.rows = [];
                    let promises = [];
                    for (const listElement of list) {
                        formData.chartData.columns.push(listElement.name);
                        promises.push(loadData({id: listElement.id, area_id: formData.area_id, data_dt_start: data_dt_start, data_dt_end: data_dt_end}));
                    }

                    Promise.all(promises).then((datas) => {
                        let i = 0;
                        for (const data of datas) {
                            console.log(data);
                            formData.min = data[0].data_value;
                            formData.max = data[0].data_value;

                            for (const datum of data) {
                                let obj = {};
                                console.log(i);
                                if (i === 0) {
                                    obj['日期'] = datum.data_dt;
                                }
                                console.log(data);
                                obj[data.name] = datum.data_value;
                                console.log(obj);
                                formData.chartData.rows.push(obj);
                                formData.max = datum.data_value > formData.max ? datum.data_value : formData.max;
                                formData.min = datum.data_value < formData.min ? datum.data_value : formData.min;

                                formData.profit = ((formData.max * 0.97 - formData.min) / formData.max * 100).toFixed(2) + '%';
                                i++;
                            }

                        }
                    });

                    /*formData.min = data[0].data_value;
                    formData.max = data[0].data_value;

                    for (const datum of data) {

                        let obj = {};
                        obj['日期'] = datum.data_dt;
                        obj[listElement.name] = datum.data_value;
                        formData.chartData.rows.push(obj);
                        formData.max = datum.data_value > formData.max ? datum.data_value : formData.max;
                        formData.min = datum.data_value < formData.min ? datum.data_value : formData.min;

                        formData.profit = ((formData.max * 0.97 - formData.min) / formData.max*100).toFixed(2)+'%';
                    }*/
                }

            },
            cal() {
                let formData = this.formData;
                formData.profit = ((formData.max * 0.97 - formData.min) / formData.max * 100).toFixed(2) + '%';

            }
        }
    }
</script>

<style lang="scss" scoped>
    .inner {
        position: absolute;
        top: 20px;
        right: 20px;
        bottom: 20px;
        left: 20px;
    }
</style>
