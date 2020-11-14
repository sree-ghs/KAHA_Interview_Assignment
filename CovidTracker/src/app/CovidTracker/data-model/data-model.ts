export interface FetchDataModel {
    delta: StateDataModel;
    total: StateDataModel;
}

export interface StateDataModel {
     confirmed: number;
     deceased: number;
     recovered: number;
}
