var vm = new Vue({
    el: '#rrapp',
    data: {
        title: null,
        code: {
            host: null,
            port: null,
            dataBase: null,
            account: null,
            password: null,
            basePackage: null,
            tablePrefix: null,
            tableNames: null
        }
    },
    methods: {
        gencode: function () {
            location.href = buildUrl("/generate/tool/generateCode", vm.code);
        },
        reset: function () {
            vm.code = {
                host: null,
                port: null,
                dataBase: null,
                account: null,
                password: null,
                basePackage: null,
                tablePrefix: null,
                tableNames: null
            };
        }
    }
});