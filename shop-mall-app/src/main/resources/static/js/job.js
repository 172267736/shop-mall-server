$(function () {
    $("#jqGrid").jqGrid({
        url: buildUrl('/jenkins/listJob', {'groupId': 1}),
        datatype: "json",
        colModel: [
            {
                label: '编号',
                name: 'id',
                index: 'id',
                align: 'center'
            },
            {label: '应用名称', name: 'jobName', index: 'jobName', align: 'center'},
            {label: '工程类型', name: 'projectTypeName', index: 'projectTypeName', align: 'center'},
            {label: '主机', name: 'hostName', index: 'hostName', align: 'center'},
            {label: '端口', name: 'port', index: 'port', align: 'center'},
            {
                label: '状态', name: 'jobState', index: 'jobState', align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                    if (rowObject.jobState === 1) {
                        //未构建
                        return '未构建';
                    } else if (rowObject.jobState === 2) {
                        //构建中
                        return '构建中';
                    } else if (rowObject.jobState === 3) {
                        //构建成功
                        return '构建成功';
                    } else if (rowObject.jobState === 4) {
                        //构建失败
                        return '构建失败';
                    } else {
                        return '';
                    }
                }
            },
            {label: '创建时间', name: 'createDate', index: 'createDate', align: 'center'},
            {
                label: '操作', name: '', align: 'center',
                formatter: function (cellvalue, options, rowObject) {
                    if (rowObject.jobState === 1) {
                        //未构建
                        return '<button class="btn btn-default" onClick="buildJob(' + rowObject.id + ')">构建</button>';
                    } else if (rowObject.jobState === 2) {
                        //构建中
                        return '';
                    } else if (rowObject.jobState === 3) {
                        //构建成功
                        return '<button class="btn btn-default" onClick="buildJob(' + rowObject.id + ')">构建</button>&nbsp;<button class="btn btn-default" onClick="closeJob(' + rowObject.id + ')">重置</button>';
                    } else if (rowObject.jobState === 4) {
                        //构建失败
                        return '<button class="btn btn-default" onClick="buildJob(' + rowObject.id + ')">构建</button>';
                    } else {
                        return '';
                    }
                }
            }
        ],
        height: '100%',
        // rownumbers: true,
        // rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        jsonReader: {
            root: "data"
        },
        gridComplete: function () {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
            //隐藏grid底部滚动条
        }
    });
});

var buildJob = function (id) {
    vm.buildJob(id);
}

var closeJob = function (id) {
    vm.closeJob(id);
}

var vm = new Vue({
    el: '#rrapp',
    data: {
        search: {
            groupId: null
        },
        servers: [],
        groups: [],
        showList: true,
        title: null,
        job: {
            jobName: null,
            description: null,
            projectType: 2,
            activeEnv: null,
            codeType: 1,
            codeAddress: null,
            jenkinsWorkspacePath: null,
            sshServerId: null,
            port: null,
            groupId: null
        }
    },
    created: function () {
        this.listAllGroup();
    },
    methods: {
        listAllGroup: function () {
            $.ajax({
                type: "GET",
                url: buildUrl("/group/listAll", null),
                dataType: "json",
                success: function (result) {
                    if (result.code === "000000") {
                        vm.groups = result.data;
                        vm.search.groupId = vm.groups[0].id;
                        vm.job.groupId = vm.groups[0].id;
                    } else {
                        vm.error = true;
                        vm.errorMsg = result.msg;
                    }
                }
            });
        },
        listAllServers: function () {
            $.ajax({
                type: "GET",
                url: buildUrl("/sshServer/listAll", null),
                dataType: "json",
                success: function (result) {
                    if (result.code === "000000") {
                        vm.servers = result.data;
                        vm.job.sshServerId = vm.servers[0].id;
                    } else {
                        vm.error = true;
                        vm.errorMsg = result.msg;
                    }
                }
            });
        },
        groupChange: function () {
            vm.reload();
        },
        query: function () {
            vm.reload();
        },
        buildJob: function (id) {
            var param = {
                "id": id
            }
            $.ajax({
                type: "POST",
                url: buildUrl("/jenkins/buildJob", param),
                dataType: "json",
                success: function (result) {
                    if (result.code === "000000") {
                        vm.reload();
                    } else {
                        vm.error = true;
                        vm.errorMsg = result.msg;
                    }
                }
            });
        },
        closeJob: function (id) {
            var param = {
                "id": id
            }
            $.ajax({
                type: "POST",
                url: buildUrl("/jenkins/killJob", param),
                dataType: "json",
                success: function (result) {
                    if (result.code === "000000") {
                        vm.reload();
                    } else {
                        vm.error = true;
                        vm.errorMsg = result.msg;
                    }
                }
            });
        },
        save: function () {
            vm.showList = false;
            vm.title = "新增应用";
            vm.listAllServers();
            vm.listAllGroup();
        },
        add: function () {
            $.ajax({
                type: "POST",
                url: buildUrl("/jenkins/createJob", vm.job),
                dataType: "json",
                success: function (result) {
                    if (result.code === "000000") {
                        vm.reload();
                    } else {
                        vm.error = true;
                        vm.errorMsg = result.msg;
                    }
                }
            });
        },
        reload: function () {
            vm.showList = true;
            console.log("bbb");
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'groupId': vm.search.groupId}
            }).trigger("reloadGrid");
        }
    }
});