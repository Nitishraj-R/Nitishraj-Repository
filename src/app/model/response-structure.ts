import { GeneratedToken } from "./generated-token";

export class ResponseStructure {
    constructor(data:GeneratedToken,message:string,status:number){
        this.data=data;
        this.message=message;
        this.status=status;
    }
    data:GeneratedToken;
    message:string;
    status:number;
}
