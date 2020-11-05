$(function () {
    $("#jqGrid").jqGrid({
        url: buildUrl('/sshServer/listServer', null),
        datatype: "json",
        colModel: [
            {label: '主机', name: 'hostName', align: 'center'},
            {label: '用户名', name: 'userName', align: 'center'},
            {label: '端口', name: 'port', align: 'center'},
            {label: '操作系统', name: 'osTypeName', align: 'center'},
            {label: '创建时间', name: 'createDate', align: 'center'}
        ],
        viewrecords: true,
        height: 400,
        rowNum: 10,
        rowList: [10, 30, 50],
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.pageIndex",
            total: "data.count",
            records: "data.pageSize"
        },
        prmNames: {
            page: "pageIndex",
            rows: "pageSize"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        search: {
            hostName: null
        },
        showList: true,
        title: null,
        sshServer: {
            hostName: null,
            userName: null,
            password: null,
            osType: 1,
            remoteDirectory: null,
            port: null
        }
    },
    methods: {
        query: function(){
            vm.reload();
        },
        save: function () {
            vm.showList = false;
            vm.title = "新增服务器";
            vm.sshServer = {};
        },
        add: function () {
            $.ajax({
                type: "POST",
                url: buildUrl("/sshServer/createServer", vm.sshServer),
                dataType: "json",
                success: function (result) {
                    if (result.code == "000000") {
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
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'hostName': vm.search.hostName},
                page: page
            }).trigger("reloadGrid");
        }
    }
});