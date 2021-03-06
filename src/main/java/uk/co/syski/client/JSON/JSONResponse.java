package uk.co.syski.client.JSON;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import uk.co.syski.client.System.CompleteSystemStatic;
import uk.co.syski.client.System.Components.Static.*;
import uk.co.syski.client.System.Components.Variable.CPUVariable;
import uk.co.syski.client.System.Components.Variable.NetworkVariable;
import uk.co.syski.client.System.Components.Variable.RAMVariable;
import uk.co.syski.client.System.Components.Variable.StorageVariable;
import uk.co.syski.client.System.RunningProcess;

public class JSONResponse
{
    //Get the JSON for whatever object is passed as a parameter to the functions.
    public static JsonObject getJSON(CompleteSystemStatic completeSystem)
    {
        return Json.object().add("action", "staticcompletesystem")
                .add("properties",
                    Json.object()
                        .add("cpu", getStaticCPUJSON(completeSystem.getCPU()))
                        .add("system", getStaticSystemJSON(completeSystem.getSystem()))
                        .add("os", getStaticOSJSON(completeSystem.getOS()))
                        .add("ram", getStaticRAMJSON(completeSystem.getRAM()))
                        .add("storage", getStaticStorageJSON(completeSystem.getStorage()))
                        .add("motherboard", getStaticMotherboardJSON(completeSystem.getMotherboard()))
                        .add("gpu", getStaticGPUJSON(completeSystem.getGPU())));

    }

    public static JsonObject getJSON(CPUStatic cpu)
    {
        return Json.object().add("action", "staticcpu")
                .add("properties", getStaticCPUJSON(cpu));
    }

    public static JsonObject getJSON(SystemStatic system)
    {
        return Json.object().add("action", "staticsystem")
                .add("properties", getStaticSystemJSON(system));

    }

    public static JsonObject getJSON(OSStatic os)
    {
        return Json.object().add("action", "staticos")
                .add("properties", getStaticOSJSON(os));
    }

    public static JsonObject getJSON(RAMStatic[] ram)
    {
        return Json.object().add("action", "staticram")
                .add("properties", Json.object().add("ram", getStaticRAMJSON(ram)));
    }

    public static JsonObject getJSON(StorageStatic[] storage)
    {
        return Json.object().add("action", "staticstorage")
                .add("properties", Json.object().add("storage", getStaticStorageJSON(storage)));
    }

    public static JsonObject getJSON(MotherboardStatic mb)
    {
        return Json.object().add("action", "staticmotherboard")
                .add("properties", getStaticMotherboardJSON(mb));
    }

    public static JsonObject getJSON(GPUStatic gpu)
    {
        return Json.object().add("action", "staticgpu")
                .add("properties", getStaticGPUJSON(gpu));
    }

    public static JsonObject getJSON(BIOSStatic bios)
    {
        return Json.object().add("action", "staticbios")
                .add("properties", getStaticBIOSJSON(bios));
    }

    public static JsonObject getJSON(CPUVariable cpu)
    {
        return Json.object().add("action", "variablecpu")
                .add("properties", getVariableCPUJSON(cpu));
    }

    public static JsonObject getJSON(RAMVariable ram)
    {
        return Json.object().add("action", "variableram")
                .add("properties", getVariableRAMJSON(ram));
    }

    public static JsonObject getJSON(StorageVariable storage)
    {
        return Json.object().add("action", "variablestorage")
                .add("properties", getVariableStorageJSON(storage));
    }

    public static JsonObject getJSON(NetworkVariable network)
    {
        return Json.object().add("action", "variablenetwork")
                .add("properties", getVariableNetworkJSON(network));
    }

    public static JsonObject getJSON(RunningProcess[] processes)
    {
        return Json.object().add("action", "runningprocesses")
                .add("properties", Json.object().add("processes", getRunningProcessesJSON(processes)));
    }

    private static JsonObject getStaticCPUJSON(CPUStatic cpu)
    {
        return Json.object()
                .add("id", cpu.getID())
                .add("model", cpu.getModel())
                .add("manufacturer", cpu.getManufacturer())
                .add("architecture", cpu.getArchitecture())
                .add("clockspeed", cpu.getClock())
                .add("corecount", cpu.getCoreCount())
                .add("threadcount", cpu.getThreadCount());
    }

    private static JsonObject getStaticSystemJSON(SystemStatic system)
    {
        return Json.object()
                .add("id", system.getID())
                .add("model", system.getModel())
                .add("manufacturer", system.getManufacturer())
                .add("type", system.getType())
                .add("hostname", system.getHostName());
    }

    private static JsonObject getStaticOSJSON(OSStatic os)
    {
        return Json.object()
                .add("name", os.getName())
                .add("version", os.getVersion())
                .add("architecture", os.getArchitecture());
    }

    private static JsonArray getStaticRAMJSON(RAMStatic[] ram)
    {
        JsonArray array = new JsonArray();
        for (RAMStatic r : ram)
            array.add(
                    Json.object()
                    .add("model", r.getModel())
                    .add("manufacturer", r.getManufacturer())
                    .add("type", r.getType())
                    .add("speed", r.getSpeed())
                    .add("size", r.getSize())
            );
        return array;
    }

    private static JsonArray getStaticStorageJSON(StorageStatic[] storage)
    {
        JsonArray array = new JsonArray();
        for (StorageStatic str : storage)
        {
            array.add(
                    Json.object()
                    .add("model", str.getModel())
                    .add("manufacturer", str.getManufacturer())
                    .add("interface", str.getType())
                    .add("size", str.getSize())
            );
        }
        return array;
    }

    private static JsonObject getStaticMotherboardJSON(MotherboardStatic mb)
    {
        return Json.object()
                .add("model", mb.getModel())
                .add("manufacturer", mb.getManufacturer())
                .add("version", mb.getVersion());
    }

    private static JsonObject getStaticGPUJSON(GPUStatic gpu)
    {
        return Json.object()
                .add("model", gpu.getModel())
                .add("manufacturer", gpu.getManufacturer());
    }

    private static JsonObject getStaticBIOSJSON(BIOSStatic bios)
    {
        return Json.object()
                .add("manufacturer", bios.getManufacturer())
                .add("caption", bios.getCaption())
                .add("version", bios.getVersion())
                .add("date", bios.getDate());
    }

    private static JsonObject getVariableCPUJSON(CPUVariable cpu)
    {
        return Json.object()
                .add("load", cpu.getLoad())
                .add("processes", cpu.getProcesses());
    }

    private static JsonObject getVariableRAMJSON(RAMVariable ram)
    {
        return Json.object()
                .add("free", ram.getFree());
    }

    /*private static JsonArray getVariableStorageJSON(StorageVariable[] storage)
    {
        JsonArray array = new JsonArray();
        for (StorageVariable str : storage)
        {
            array.add(
                    Json.object()
                            .add("time", str.getTime())
                            .add("transfers", str.getTransfers())
                            .add("reads", str.getReads())
                            .add("writes", str.getWrites())
                            .add("bytereads", str.getByteReads())
                            .add("bytewrites", str.getByteWrites())
            );
        }
        return array;
    }*/

    private static JsonObject getVariableStorageJSON(StorageVariable storage)
    {
        return Json.object()
                .add("time", storage.getTime())
                .add("transfers", storage.getTransfers())
                .add("reads", storage.getReads())
                .add("writes", storage.getWrites())
                .add("bytereads", storage.getByteReads())
                .add("bytewrites", storage.getByteWrites());
    }

    private static JsonObject getVariableNetworkJSON(NetworkVariable network)
    {
        return Json.object()
                .add("packets", network.getPackets())
                .add("bytes", network.getBytes())
                .add("bandwidth", network.getBandwidth());
    }

    private static JsonArray getRunningProcessesJSON(RunningProcess[] processes)
    {
        JsonArray array = new JsonArray();
        for (RunningProcess proc : processes)
        {
            array.add(
                    Json.object()
                            .add("id", proc.getID())
                            .add("name", proc.getName())
                            .add("memsize", proc.getSize())
                            .add("kerneltime", proc.getKernalTime())
                            .add("path", proc.getPath())
                            .add("threads", proc.getThreadCount())
                            .add("uptime", proc.getUptime())
                            .add("parentid", proc.getParent())
            );
        }
        return array;
    }

}
